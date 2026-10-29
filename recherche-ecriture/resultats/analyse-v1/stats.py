import re, glob, os, statistics
D = "/tmp/claude-0/-home-user-Code-space-test/1966714b-a84e-51c7-8837-0e42d26d861f/scratchpad/lecture/devperso/"
files = sorted(glob.glob(D + "*.txt"))
pats = {
 "guillemets «»": r"[«»]",
 "guillemets droits \"": r'"',
 "deux-points :": r":",
 "point-virgule ;": r";",
 "tiret cadratin —": r"—",
 "tiret demi –": r"–",
 "parenthèses (": r"\(",
 "point d'interr ?": r"\?",
 "point d'exclam !": r"!",
 "points de susp …/...": r"…|\.\.\.",
 "vous": r"\b[Vv]ous\b",
 "nous": r"\b[Nn]ous\b",
 "on": r"\b[Oo]n\b",
 "je/j'": r"\b[Jj]e\b|\bj'",
 "tu/te/ton/ta/tes": r"\b([Tt]u|[Tt]es|[Tt]on|[Tt]a|[Tt]es|[Tt]oi)\b",
 "c'est": r"\b[Cc]'est\b",
 "ce n'est pas": r"\b[Cc]e n'est pas\b|\b[Cc]'est pas\b",
 "pas X mais/c'est": r"\bmais\b",
 "Il s'agit": r"\b[Ii]l s'agit\b",
 "par exemple / exemple": r"\b[Ee]xemple",
 "Ainsi / Ce qui / Ce que": r"\b([Aa]insi|[Cc]e qui|[Cc]e que)\b",
 "Pourtant / Cependant / Toutefois / Mais": r"\b(Pourtant|Cependant|Toutefois|En revanche|Néanmoins)\b",
 "Dans / Pour": r"\b(Dans|Pour)\b",
 "Un / Une (début de phrase)": r"(?<=[\.\n] )(Un|Une)\b",
 "Vous (majuscule début)": r"(?<=[\.\n] )Vous\b",
 "Il/Elle (sujet)": r"(?<=[\.\n] )(Il|Elle)\b",
 "Ce/Cela/Celui": r"\b([Cc]e|[Cc]ela|[Cc]elui|[Cc]ette)\b",
 "non (mot)": r"\bnon\b",
 "Le non/le oui": r"\b[Ll]e (non|oui)\b",
 "dire non": r"dire non|dire « non »|« non »|\"non\"",
 "adverbes -ment": r"\b\w+ment\b",
 "gens": r"\b[Gg]ens\b",
 "vraiment": r"\bvraiment\b",
 "bien sûr": r"\bbien sûr\b",
 "très": r"\btrès\b",
 "si (conj)": r"\bsi\b",
 "tout / tous / toute": r"\b([Tt]out|[Tt]ous|[Tt]oute|[Tt]outes)\b",
 "lorsque/lorsqu'": r"\b[Ll]orsqu?[e']",
 "quand": r"\b[Qq]uand\b",
 "qui/que (relatif)": r"\b(qui|que|qu')\b",
 "réponse/relation": r"\b(relation|relations)\b",
 "ne ... pas (négation)": r"\bne\b[^.]*?\bpas\b|\bn'[^.]*?\bpas\b",
 "ne...jamais": r"\bjamais\b",
 "Exemple:": r"Exemple\s*:|exemple\s*:|par exemple",
 "« » citation": r"« ",
 "signe '—' tiret liste": r"^\s*[—–-]\s",
 "liste numérotée '1.'": r"^\s*\d+\.\s",
 "intertitre-court (sans point final, <8 mots)": r"XXXX",
}
def split_sents(t):
    t = re.sub(r"\s+", " ", t)
    parts = re.split(r"(?<=[\.\?\!…])\s+(?=[A-ZÉÈÀÂÎÔÙÇ«\"—\-\d])", t)
    return [p.strip() for p in parts if p.strip()]
def para(t):
    return [p for p in re.split(r"\n\s*\n", t) if p.strip()]

rows = []
for f in files:
    raw = open(f, encoding="utf-8").read()
    name = os.path.basename(f)
    # strip "NN\t" prefixes not present in files; they are raw
    text = raw
    words = re.findall(r"\b[\wÀ-ÿ'’-]+\b", text)
    sents = split_sents(text)
    sl = [len(re.findall(r"\b[\wÀ-ÿ'’-]+\b", s)) for s in sents]
    paras = para(text)
    pl = [len(re.findall(r"\b[\wÀ-ÿ'’-]+\b", p)) for p in paras]
    wl = [len(w) for w in words]
    short = sum(1 for x in sl if x <= 6)
    long_ = sum(1 for x in sl if x >= 30)
    r = dict(name=name, words=len(words), sents=len(sents),
             sl_mean=round(statistics.mean(sl),1), sl_med=statistics.median(sl),
             sl_sd=round(statistics.pstdev(sl),1), sl_max=max(sl),
             short_pct=round(100*short/len(sents),1), long_pct=round(100*long_/len(sents),1),
             paras=len(paras), pl_mean=round(statistics.mean(pl),1),
             wlen=round(statistics.mean(wl),2))
    rows.append(r)
    cnt = {}
    for k,p in pats.items():
        if p == "XXXX": continue
        cnt[k] = len(re.findall(p, text, flags=re.M))
    r["cnt"] = cnt

print("FILE | mots | phrases | longueur moy (sd) | méd | max | %<=6 | %>=30 | §  | mots/§ | long.mot")
for r in rows:
    print(f"{r['name']} | {r['words']} | {r['sents']} | {r['sl_mean']} ({r['sl_sd']}) | {r['sl_med']} | {r['sl_max']} | {r['short_pct']} | {r['long_pct']} | {r['paras']} | {r['pl_mean']} | {r['wlen']}")
print()
keys = list(pats.keys())
keys = [k for k in keys if k != "intertitre-court (sans point final, <8 mots)"]
hdr = ["motif"] + [r["name"].replace(".txt","") for r in rows]
print(" | ".join(hdr))
for k in keys:
    print(" | ".join([k] + [str(r["cnt"][k]) for r in rows]))
