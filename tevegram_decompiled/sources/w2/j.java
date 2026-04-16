package w2;

import b6.g0;
import i7.x;
import java.nio.ByteBuffer;
import java.util.UUID;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f9767a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9768b = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static byte[] a(UUID uuid, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (bArr == null || bArr.length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static q2.a b(g1.p pVar) {
        int g9 = pVar.g();
        if (pVar.g() != 1684108385) {
            g1.a.D("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int g10 = pVar.g() & 16777215;
        String str = g10 == 13 ? "image/jpeg" : g10 == 14 ? "image/png" : null;
        if (str == null) {
            androidx.activity.g.t(g10, "Unrecognized cover art flags: ", "MetadataUtil");
            return null;
        }
        pVar.G(4);
        int i9 = g9 - 16;
        byte[] bArr = new byte[i9];
        pVar.e(0, i9, bArr);
        return new q2.a(str, null, 3, bArr);
    }

    public static q2.m c(int i9, g1.p pVar, String str) {
        int g9 = pVar.g();
        if (pVar.g() == 1684108385 && g9 >= 22) {
            pVar.G(10);
            int z8 = pVar.z();
            if (z8 > 0) {
                String m9 = androidx.activity.g.m(z8, "");
                int z9 = pVar.z();
                if (z9 > 0) {
                    m9 = m9 + "/" + z9;
                }
                return new q2.m(str, null, g0.q(m9));
            }
        }
        g1.a.D("MetadataUtil", "Failed to parse index/count attribute: ".concat(g5.c.b(i9)));
        return null;
    }

    public static x d(byte[] bArr) {
        g1.p pVar = new g1.p(bArr);
        if (pVar.f3701c < 32) {
            return null;
        }
        pVar.F(0);
        int a9 = pVar.a();
        int g9 = pVar.g();
        if (g9 != a9) {
            g1.a.D("PsshAtomUtil", "Advertised atom size (" + g9 + ") does not match buffer size: " + a9);
            return null;
        }
        int g10 = pVar.g();
        if (g10 != 1886614376) {
            androidx.activity.g.t(g10, "Atom type is not pssh: ", "PsshAtomUtil");
            return null;
        }
        int i9 = g5.c.i(pVar.g());
        if (i9 > 1) {
            androidx.activity.g.t(i9, "Unsupported pssh version: ", "PsshAtomUtil");
            return null;
        }
        UUID uuid = new UUID(pVar.n(), pVar.n());
        if (i9 == 1) {
            int x6 = pVar.x();
            UUID[] uuidArr = new UUID[x6];
            for (int i10 = 0; i10 < x6; i10++) {
                uuidArr[i10] = new UUID(pVar.n(), pVar.n());
            }
        }
        int x8 = pVar.x();
        int a10 = pVar.a();
        if (x8 == a10) {
            byte[] bArr2 = new byte[x8];
            pVar.e(0, x8, bArr2);
            return new x(uuid, i9, bArr2);
        }
        g1.a.D("PsshAtomUtil", "Atom data size (" + x8 + ") does not match the bytes left: " + a10);
        return null;
    }

    public static q2.m e(int i9, g1.p pVar, String str) {
        int g9 = pVar.g();
        if (pVar.g() == 1684108385) {
            pVar.G(8);
            return new q2.m(str, null, g0.q(pVar.p(g9 - 16)));
        }
        g1.a.D("MetadataUtil", "Failed to parse text attribute: ".concat(g5.c.b(i9)));
        return null;
    }

    public static q2.i f(int i9, String str, g1.p pVar, boolean z8, boolean z9) {
        int g9 = g(pVar);
        if (z9) {
            g9 = Math.min(1, g9);
        }
        if (g9 >= 0) {
            return z8 ? new q2.m(str, null, g0.q(Integer.toString(g9))) : new q2.e("und", str, Integer.toString(g9));
        }
        g1.a.D("MetadataUtil", "Failed to parse uint8 attribute: ".concat(g5.c.b(i9)));
        return null;
    }

    public static int g(g1.p pVar) {
        pVar.G(4);
        if (pVar.g() == 1684108385) {
            pVar.G(8);
            return pVar.t();
        }
        g1.a.D("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static boolean h(d2.n nVar, boolean z8, boolean z9) {
        boolean z10;
        int i9;
        int i10;
        boolean z11;
        long e9 = nVar.e();
        long j5 = IjkMediaMeta.AV_CH_TOP_FRONT_LEFT;
        long j9 = -1;
        int i11 = (e9 > (-1L) ? 1 : (e9 == (-1L) ? 0 : -1));
        if (i11 != 0 && e9 <= IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            j5 = e9;
        }
        int i12 = (int) j5;
        g1.p pVar = new g1.p(64);
        int i13 = 0;
        int i14 = 0;
        boolean z12 = false;
        while (i14 < i12) {
            pVar.C(8);
            if (!nVar.n(pVar.f3699a, i13, 8, true)) {
                break;
            }
            long v8 = pVar.v();
            int g9 = pVar.g();
            if (v8 == 1) {
                nVar.a(8, 8, pVar.f3699a);
                pVar.E(16);
                i9 = i14;
                v8 = pVar.n();
                i10 = 16;
            } else {
                if (v8 == 0) {
                    long e10 = nVar.e();
                    if (e10 != j9) {
                        v8 = (e10 - nVar.o()) + 8;
                    }
                }
                i9 = i14;
                i10 = 8;
            }
            long j10 = i10;
            if (v8 < j10) {
                return false;
            }
            int i15 = i9 + i10;
            if (g9 == 1836019574) {
                i12 += (int) v8;
                if (i11 != 0 && i12 > e9) {
                    i12 = (int) e9;
                }
                i14 = i15;
            } else {
                if (g9 == 1836019558 || g9 == 1836475768) {
                    z10 = true;
                    break;
                }
                if (g9 == 1835295092) {
                    z12 = true;
                }
                int i16 = i11;
                if ((i15 + v8) - j10 >= i12) {
                    break;
                }
                int i17 = (int) (v8 - j10);
                i14 = i15 + i17;
                if (g9 == 1718909296) {
                    if (i17 < 8) {
                        return false;
                    }
                    pVar.C(i17);
                    nVar.a(0, i17, pVar.f3699a);
                    int i18 = i17 / 4;
                    for (int i19 = 0; i19 < i18; i19++) {
                        if (i19 != 1) {
                            int g10 = pVar.g();
                            if ((g10 >>> 8) != 3368816 && (g10 != 1751476579 || !z9)) {
                                for (int i20 = 0; i20 < 29; i20++) {
                                    if (f9768b[i20] != g10) {
                                    }
                                }
                            }
                            z11 = true;
                            break;
                        }
                        pVar.G(4);
                    }
                    z11 = z12;
                    if (!z11) {
                        return false;
                    }
                    z12 = z11;
                } else if (i17 != 0) {
                    nVar.p(i17);
                }
                i11 = i16;
            }
            j9 = -1;
            i13 = 0;
        }
        z10 = false;
        return z12 && z8 == z10;
    }
}
