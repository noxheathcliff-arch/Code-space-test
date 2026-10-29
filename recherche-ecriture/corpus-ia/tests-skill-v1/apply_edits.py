import sys, json
path = sys.argv[1]
edits = json.load(open(sys.argv[2]))
s = open(path, encoding='utf-8').read()
for old, new in edits:
    n = s.count(old)
    if n != 1:
        print("ECHEC (%d occurrences):" % n, old[:70]); sys.exit(1)
    s = s.replace(old, new)
open(path, 'w', encoding='utf-8').write(s)
print("ok", len(edits), "edits")
