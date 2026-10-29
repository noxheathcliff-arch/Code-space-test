import sys, os
src, start, end, prefix, outdir = sys.argv[1], int(sys.argv[2]), int(sys.argv[3]), sys.argv[4], sys.argv[5]
lines = open(src).read().split('\n')[start-1:end]
os.makedirs(outdir, exist_ok=True)
buf, n, k = [], 0, 0
for l in lines:
    if l.startswith('#'):
        if n >= 600:
            k += 1; open(f'{outdir}/{prefix}_{k:03d}.txt','w').write('\n\n'.join(buf)); buf, n = [], 0
        continue
    buf.append(l); n += len(l.split())
    if n >= 900:
        k += 1; open(f'{outdir}/{prefix}_{k:03d}.txt','w').write('\n\n'.join(buf)); buf, n = [], 0
print(prefix, k, 'chunks')
