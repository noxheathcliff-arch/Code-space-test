import sys, struct, zlib, os, re
data = open(sys.argv[1], 'rb').read(); out = sys.argv[2]; n = 0; pos = 0
while True:
    i = data.find(b'PK\x03\x04', pos)
    if i < 0: break
    try:
        flag, meth, = struct.unpack('<HH', data[i+6:i+10])
        csize, usize, nl, xl = struct.unpack('<IIHH', data[i+18:i+30])
        name = data[i+30:i+30+nl].decode('utf-8', 'replace'); start = i+30+nl+xl
        if meth == 8:
            d = zlib.decompressobj(-15); raw = d.decompress(data[start:start + (csize if csize and not flag & 8 else len(data))])
            end = start + (csize if csize and not flag & 8 else len(data) - len(d.unused_data) - start)
        else:
            raw = data[start:start+csize]; end = start + csize
        p = os.path.join(out, re.sub(r'\.\.', '_', name))
        if not name.endswith('/'):
            os.makedirs(os.path.dirname(p) or out, exist_ok=True); open(p, 'wb').write(raw); n += 1
        pos = max(end, i + 4)
    except Exception as e:
        pos = i + 4
print(n, 'fichiers récupérés')
