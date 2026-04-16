package s1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements k {

    /* renamed from: i, reason: collision with root package name */
    public int f8671i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8672j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f8673k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f8674l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f8675m;

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0737  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x07b5  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x07c3  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0825  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0833  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0841  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x085d  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x086b  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0887  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0895  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x08b1  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x08cd  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x08e9  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x08f7  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0913  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x093d  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0959  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0983  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0991  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x09ad  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x09c9  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x09e5  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x09f3  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0a0f  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0a1d  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0a39  */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0a47  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0a55  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0a71  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0a7f  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0a8d  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x0a9b  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0aa9  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0ad3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0b0b  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b19  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0b27  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0b35  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0b43  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0b51  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0b5f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0b6d  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0b7b  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0b89  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0b97  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0ba5  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x0bc1  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0bcf  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x0bdd  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0beb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0c07  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0c15  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x0c23  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0c31  */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0c3f  */
    /* JADX WARN: Removed duplicated region for block: B:670:0x0c4d  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0c5b  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0c69  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0c77  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x0c85  */
    /* JADX WARN: Removed duplicated region for block: B:685:0x0c93  */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0ca1  */
    /* JADX WARN: Removed duplicated region for block: B:691:0x0caf  */
    /* JADX WARN: Removed duplicated region for block: B:694:0x0cbd  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x0ccb  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0cd9  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x0ce7  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:712:0x0d0b  */
    /* JADX WARN: Removed duplicated region for block: B:715:0x0d16  */
    /* JADX WARN: Removed duplicated region for block: B:718:0x0d21  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x0d2c  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0d37  */
    /* JADX WARN: Removed duplicated region for block: B:727:0x0d42  */
    /* JADX WARN: Removed duplicated region for block: B:731:0x0d4f  */
    /* JADX WARN: Removed duplicated region for block: B:735:0x0d56  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x0d5d  */
    /* JADX WARN: Removed duplicated region for block: B:737:0x0d64  */
    /* JADX WARN: Removed duplicated region for block: B:738:0x0d6b  */
    /* JADX WARN: Removed duplicated region for block: B:739:0x0d72  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:740:0x0d79  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x0d80  */
    /* JADX WARN: Removed duplicated region for block: B:742:0x0d87  */
    /* JADX WARN: Removed duplicated region for block: B:743:0x0d8e  */
    /* JADX WARN: Removed duplicated region for block: B:744:0x0d95  */
    /* JADX WARN: Removed duplicated region for block: B:745:0x0d9c  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x0da3  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0daa  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0db1  */
    /* JADX WARN: Removed duplicated region for block: B:749:0x0db8  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0dbf  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x0dc6  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x0dcd  */
    /* JADX WARN: Removed duplicated region for block: B:753:0x0dd4  */
    /* JADX WARN: Removed duplicated region for block: B:754:0x0ddb  */
    /* JADX WARN: Removed duplicated region for block: B:755:0x0de2  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0de9  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0df0  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:759:0x0dfe  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0e05  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x0e0c  */
    /* JADX WARN: Removed duplicated region for block: B:762:0x0e13  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x0e1a  */
    /* JADX WARN: Removed duplicated region for block: B:764:0x0e21  */
    /* JADX WARN: Removed duplicated region for block: B:765:0x0e28  */
    /* JADX WARN: Removed duplicated region for block: B:766:0x0e2f  */
    /* JADX WARN: Removed duplicated region for block: B:767:0x0e36  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0e3d  */
    /* JADX WARN: Removed duplicated region for block: B:769:0x0e44  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:770:0x0e4b  */
    /* JADX WARN: Removed duplicated region for block: B:771:0x0e52  */
    /* JADX WARN: Removed duplicated region for block: B:772:0x0e59  */
    /* JADX WARN: Removed duplicated region for block: B:773:0x0e60  */
    /* JADX WARN: Removed duplicated region for block: B:774:0x0e67  */
    /* JADX WARN: Removed duplicated region for block: B:775:0x0e6e  */
    /* JADX WARN: Removed duplicated region for block: B:776:0x0e75  */
    /* JADX WARN: Removed duplicated region for block: B:777:0x0e7c  */
    /* JADX WARN: Removed duplicated region for block: B:778:0x0e83  */
    /* JADX WARN: Removed duplicated region for block: B:779:0x0e8a  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x0e91  */
    /* JADX WARN: Removed duplicated region for block: B:781:0x0e98  */
    /* JADX WARN: Removed duplicated region for block: B:782:0x0e9f  */
    /* JADX WARN: Removed duplicated region for block: B:783:0x0ea6  */
    /* JADX WARN: Removed duplicated region for block: B:784:0x0ead  */
    /* JADX WARN: Removed duplicated region for block: B:785:0x0eb4  */
    /* JADX WARN: Removed duplicated region for block: B:786:0x0ebb  */
    /* JADX WARN: Removed duplicated region for block: B:787:0x0ec2  */
    /* JADX WARN: Removed duplicated region for block: B:788:0x0ec9  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x0ed0  */
    /* JADX WARN: Removed duplicated region for block: B:790:0x0ed7  */
    /* JADX WARN: Removed duplicated region for block: B:791:0x0ede  */
    /* JADX WARN: Removed duplicated region for block: B:792:0x0ee5  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x0eec  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x0ef3  */
    /* JADX WARN: Removed duplicated region for block: B:795:0x0efa  */
    /* JADX WARN: Removed duplicated region for block: B:796:0x0f01  */
    /* JADX WARN: Removed duplicated region for block: B:797:0x0f08  */
    /* JADX WARN: Removed duplicated region for block: B:798:0x0f0f  */
    /* JADX WARN: Removed duplicated region for block: B:799:0x0f16  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:800:0x0f1d  */
    /* JADX WARN: Removed duplicated region for block: B:801:0x0f24  */
    /* JADX WARN: Removed duplicated region for block: B:802:0x0f2b  */
    /* JADX WARN: Removed duplicated region for block: B:803:0x0f32  */
    /* JADX WARN: Removed duplicated region for block: B:804:0x0f39  */
    /* JADX WARN: Removed duplicated region for block: B:805:0x0f40  */
    /* JADX WARN: Removed duplicated region for block: B:806:0x0f47  */
    /* JADX WARN: Removed duplicated region for block: B:807:0x0f4e  */
    /* JADX WARN: Removed duplicated region for block: B:808:0x0f55  */
    /* JADX WARN: Removed duplicated region for block: B:809:0x0f5c  */
    /* JADX WARN: Removed duplicated region for block: B:810:0x0f63  */
    /* JADX WARN: Removed duplicated region for block: B:811:0x0f6a  */
    /* JADX WARN: Removed duplicated region for block: B:812:0x0f71  */
    /* JADX WARN: Removed duplicated region for block: B:813:0x0f78  */
    /* JADX WARN: Removed duplicated region for block: B:814:0x0f7f  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x0f86  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x0f8d  */
    /* JADX WARN: Removed duplicated region for block: B:817:0x0f94  */
    /* JADX WARN: Removed duplicated region for block: B:818:0x0f9b  */
    /* JADX WARN: Removed duplicated region for block: B:819:0x0fa2  */
    /* JADX WARN: Removed duplicated region for block: B:820:0x0fa9  */
    /* JADX WARN: Removed duplicated region for block: B:821:0x0fb0  */
    /* JADX WARN: Removed duplicated region for block: B:822:0x0fb7  */
    /* JADX WARN: Removed duplicated region for block: B:823:0x0fbe  */
    /* JADX WARN: Removed duplicated region for block: B:824:0x0fc5  */
    /* JADX WARN: Removed duplicated region for block: B:825:0x0fcc  */
    /* JADX WARN: Removed duplicated region for block: B:826:0x0fd3  */
    /* JADX WARN: Removed duplicated region for block: B:827:0x0fda  */
    /* JADX WARN: Removed duplicated region for block: B:828:0x0fe1  */
    /* JADX WARN: Removed duplicated region for block: B:829:0x0fe8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:830:0x0fef  */
    /* JADX WARN: Removed duplicated region for block: B:831:0x0ff6  */
    /* JADX WARN: Removed duplicated region for block: B:832:0x0ffd  */
    /* JADX WARN: Removed duplicated region for block: B:833:0x1004  */
    /* JADX WARN: Removed duplicated region for block: B:834:0x100b  */
    /* JADX WARN: Removed duplicated region for block: B:835:0x1012  */
    /* JADX WARN: Removed duplicated region for block: B:836:0x1019  */
    /* JADX WARN: Removed duplicated region for block: B:837:0x1020  */
    /* JADX WARN: Removed duplicated region for block: B:838:0x1027  */
    /* JADX WARN: Removed duplicated region for block: B:839:0x102e  */
    /* JADX WARN: Removed duplicated region for block: B:840:0x1035  */
    /* JADX WARN: Removed duplicated region for block: B:841:0x103c  */
    /* JADX WARN: Removed duplicated region for block: B:842:0x1043  */
    /* JADX WARN: Removed duplicated region for block: B:843:0x104a  */
    /* JADX WARN: Removed duplicated region for block: B:844:0x1051  */
    /* JADX WARN: Removed duplicated region for block: B:845:0x1058  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x105f  */
    /* JADX WARN: Removed duplicated region for block: B:847:0x1066  */
    /* JADX WARN: Removed duplicated region for block: B:848:0x106d  */
    /* JADX WARN: Removed duplicated region for block: B:849:0x1074  */
    /* JADX WARN: Removed duplicated region for block: B:850:0x107b  */
    /* JADX WARN: Removed duplicated region for block: B:851:0x1082  */
    /* JADX WARN: Removed duplicated region for block: B:852:0x1089  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x1090  */
    /* JADX WARN: Removed duplicated region for block: B:854:0x1097  */
    /* JADX WARN: Removed duplicated region for block: B:855:0x109e  */
    /* JADX WARN: Removed duplicated region for block: B:856:0x10a5  */
    /* JADX WARN: Removed duplicated region for block: B:857:0x10ac  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x10b3  */
    /* JADX WARN: Removed duplicated region for block: B:859:0x10ba  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:860:0x10c1  */
    /* JADX WARN: Removed duplicated region for block: B:861:0x10c8  */
    /* JADX WARN: Removed duplicated region for block: B:862:0x10cf  */
    /* JADX WARN: Removed duplicated region for block: B:863:0x10d6  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x10dd  */
    /* JADX WARN: Removed duplicated region for block: B:865:0x10e4  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x10eb  */
    /* JADX WARN: Removed duplicated region for block: B:867:0x10f2  */
    /* JADX WARN: Removed duplicated region for block: B:868:0x10f9  */
    /* JADX WARN: Removed duplicated region for block: B:869:0x1100  */
    /* JADX WARN: Removed duplicated region for block: B:870:0x1107  */
    /* JADX WARN: Removed duplicated region for block: B:871:0x110e  */
    /* JADX WARN: Removed duplicated region for block: B:872:0x1115  */
    /* JADX WARN: Removed duplicated region for block: B:873:0x111c  */
    /* JADX WARN: Removed duplicated region for block: B:874:0x1123  */
    /* JADX WARN: Removed duplicated region for block: B:875:0x112a  */
    /* JADX WARN: Removed duplicated region for block: B:876:0x1131  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x1138  */
    /* JADX WARN: Removed duplicated region for block: B:878:0x113f  */
    /* JADX WARN: Removed duplicated region for block: B:879:0x1146  */
    /* JADX WARN: Removed duplicated region for block: B:880:0x114d  */
    /* JADX WARN: Removed duplicated region for block: B:881:0x1154  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x115b  */
    /* JADX WARN: Removed duplicated region for block: B:883:0x1162  */
    /* JADX WARN: Removed duplicated region for block: B:884:0x1169  */
    /* JADX WARN: Removed duplicated region for block: B:885:0x116f  */
    /* JADX WARN: Removed duplicated region for block: B:886:0x1175  */
    /* JADX WARN: Removed duplicated region for block: B:887:0x117b  */
    /* JADX WARN: Removed duplicated region for block: B:888:0x1181  */
    /* JADX WARN: Removed duplicated region for block: B:889:0x1187  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:890:0x118d  */
    /* JADX WARN: Removed duplicated region for block: B:891:0x1193  */
    /* JADX WARN: Removed duplicated region for block: B:892:0x1199  */
    /* JADX WARN: Removed duplicated region for block: B:893:0x119f  */
    /* JADX WARN: Removed duplicated region for block: B:894:0x11a5  */
    /* JADX WARN: Removed duplicated region for block: B:895:0x11ab  */
    /* JADX WARN: Removed duplicated region for block: B:896:0x11b1  */
    /* JADX WARN: Removed duplicated region for block: B:897:0x11b7  */
    /* JADX WARN: Removed duplicated region for block: B:898:0x11bd  */
    /* JADX WARN: Removed duplicated region for block: B:899:0x11c3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 8798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.<init>(android.content.Context):void");
    }

    public static void a(c cVar, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i9) {
        f fVar = (f) cVar.f8674l;
        MediaCodec mediaCodec = (MediaCodec) cVar.f8673k;
        HandlerThread handlerThread = fVar.f8690b;
        g1.a.k(fVar.f8691c == null);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        mediaCodec.setCallback(fVar, handler);
        fVar.f8691c = handler;
        g1.a.b("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i9);
        g1.a.r();
        ((l) cVar.f8675m).start();
        g1.a.b("startCodec");
        mediaCodec.start();
        g1.a.r();
        cVar.f8671i = 1;
    }

    public static String c(int i9, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i9 == 1) {
            sb.append("Audio");
        } else if (i9 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i9);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // s1.k
    public void b(int i9, j1.a aVar, long j5, int i10) {
        ((l) this.f8675m).b(i9, aVar, j5, i10);
    }

    @Override // s1.k
    public void d(long j5, int i9, int i10, int i11) {
        ((l) this.f8675m).d(j5, i9, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[Catch: all -> 0x0032, DONT_GENERATE, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x000e, B:6:0x0013, B:8:0x0017, B:10:0x001b, B:12:0x0025, B:18:0x0030, B:21:0x0035, B:25:0x0040, B:28:0x0044, B:30:0x0050, B:31:0x0077, B:35:0x006d, B:36:0x0079, B:37:0x007e, B:39:0x007f, B:40:0x0081, B:41:0x0082, B:42:0x0084, B:43:0x0085, B:44:0x0087), top: B:3:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x000e, B:6:0x0013, B:8:0x0017, B:10:0x001b, B:12:0x0025, B:18:0x0030, B:21:0x0035, B:25:0x0040, B:28:0x0044, B:30:0x0050, B:31:0x0077, B:35:0x006d, B:36:0x0079, B:37:0x007e, B:39:0x007f, B:40:0x0081, B:41:0x0082, B:42:0x0084, B:43:0x0085, B:44:0x0087), top: B:3:0x000e }] */
    @Override // s1.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e(android.media.MediaCodec.BufferInfo r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f8675m
            s1.l r0 = (s1.l) r0
            r0.i()
            java.lang.Object r0 = r10.f8674l
            s1.f r0 = (s1.f) r0
            java.lang.Object r1 = r0.f8689a
            monitor-enter(r1)
            java.lang.IllegalStateException r2 = r0.f8701n     // Catch: java.lang.Throwable -> L32
            r3 = 0
            if (r2 != 0) goto L85
            android.media.MediaCodec$CodecException r2 = r0.f8697j     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L82
            android.media.MediaCodec$CryptoException r2 = r0.f8698k     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L7f
            long r2 = r0.f8699l     // Catch: java.lang.Throwable -> L32
            r4 = 0
            r6 = 0
            r7 = 1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 > 0) goto L2c
            boolean r2 = r0.f8700m     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L2a
            goto L2c
        L2a:
            r2 = 0
            goto L2d
        L2c:
            r2 = 1
        L2d:
            r3 = -1
            if (r2 == 0) goto L35
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            return r3
        L32:
            r0 = move-exception
            r11 = r0
            goto L88
        L35:
            o3.r r2 = r0.f8693e     // Catch: java.lang.Throwable -> L32
            int r4 = r2.f7795b     // Catch: java.lang.Throwable -> L32
            int r5 = r2.f7796c     // Catch: java.lang.Throwable -> L32
            if (r4 != r5) goto L3e
            r6 = 1
        L3e:
            if (r6 == 0) goto L42
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            return r3
        L42:
            if (r4 == r5) goto L79
            int[] r3 = r2.f7794a     // Catch: java.lang.Throwable -> L32
            r3 = r3[r4]     // Catch: java.lang.Throwable -> L32
            int r4 = r4 + r7
            int r5 = r2.f7797d     // Catch: java.lang.Throwable -> L32
            r4 = r4 & r5
            r2.f7795b = r4     // Catch: java.lang.Throwable -> L32
            if (r3 < 0) goto L6a
            android.media.MediaFormat r2 = r0.h     // Catch: java.lang.Throwable -> L32
            g1.a.l(r2)     // Catch: java.lang.Throwable -> L32
            java.util.ArrayDeque r0 = r0.f8694f     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.remove()     // Catch: java.lang.Throwable -> L32
            android.media.MediaCodec$BufferInfo r0 = (android.media.MediaCodec.BufferInfo) r0     // Catch: java.lang.Throwable -> L32
            int r5 = r0.offset     // Catch: java.lang.Throwable -> L32
            int r6 = r0.size     // Catch: java.lang.Throwable -> L32
            long r7 = r0.presentationTimeUs     // Catch: java.lang.Throwable -> L32
            int r9 = r0.flags     // Catch: java.lang.Throwable -> L32
            r4 = r11
            r4.set(r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L32
            goto L77
        L6a:
            r11 = -2
            if (r3 != r11) goto L77
            java.util.ArrayDeque r11 = r0.f8695g     // Catch: java.lang.Throwable -> L32
            java.lang.Object r11 = r11.remove()     // Catch: java.lang.Throwable -> L32
            android.media.MediaFormat r11 = (android.media.MediaFormat) r11     // Catch: java.lang.Throwable -> L32
            r0.h = r11     // Catch: java.lang.Throwable -> L32
        L77:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            return r3
        L79:
            java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L32
            r11.<init>()     // Catch: java.lang.Throwable -> L32
            throw r11     // Catch: java.lang.Throwable -> L32
        L7f:
            r0.f8698k = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L82:
            r0.f8697j = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L85:
            r0.f8701n = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L88:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.e(android.media.MediaCodec$BufferInfo):int");
    }

    @Override // s1.k
    public void flush() {
        ((l) this.f8675m).flush();
        ((MediaCodec) this.f8673k).flush();
        f fVar = (f) this.f8674l;
        synchronized (fVar.f8689a) {
            fVar.f8699l++;
            Handler handler = fVar.f8691c;
            int i9 = g1.w.f3713a;
            handler.post(new a7.a(fVar, 21));
        }
        ((MediaCodec) this.f8673k).start();
    }

    @Override // s1.k
    public ByteBuffer getInputBuffer(int i9) {
        return ((MediaCodec) this.f8673k).getInputBuffer(i9);
    }

    @Override // s1.k
    public ByteBuffer getOutputBuffer(int i9) {
        return ((MediaCodec) this.f8673k).getOutputBuffer(i9);
    }

    @Override // s1.k
    public MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        f fVar = (f) this.f8674l;
        synchronized (fVar.f8689a) {
            try {
                mediaFormat = fVar.h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // s1.k
    public void h(b2.m mVar, Handler handler) {
        ((MediaCodec) this.f8673k).setOnFrameRenderedListener(new a(this, mVar, 0), handler);
    }

    @Override // s1.k
    public void i(int i9) {
        ((MediaCodec) this.f8673k).setVideoScalingMode(i9);
    }

    @Override // s1.k
    public void o(Surface surface) {
        ((MediaCodec) this.f8673k).setOutputSurface(surface);
    }

    @Override // s1.k
    public void r(int i9, long j5) {
        ((MediaCodec) this.f8673k).releaseOutputBuffer(i9, j5);
    }

    @Override // s1.k
    public void release() {
        try {
            if (this.f8671i == 1) {
                ((l) this.f8675m).shutdown();
                f fVar = (f) this.f8674l;
                synchronized (fVar.f8689a) {
                    fVar.f8700m = true;
                    fVar.f8690b.quit();
                    fVar.a();
                }
            }
            this.f8671i = 2;
            if (this.f8672j) {
                return;
            }
            ((MediaCodec) this.f8673k).release();
            this.f8672j = true;
        } catch (Throwable th) {
            if (!this.f8672j) {
                ((MediaCodec) this.f8673k).release();
                this.f8672j = true;
            }
            throw th;
        }
    }

    @Override // s1.k
    public void releaseOutputBuffer(int i9, boolean z8) {
        ((MediaCodec) this.f8673k).releaseOutputBuffer(i9, z8);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[Catch: all -> 0x0032, DONT_GENERATE, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x000e, B:6:0x0013, B:8:0x0017, B:10:0x001b, B:12:0x0025, B:18:0x0030, B:21:0x0034, B:26:0x004c, B:29:0x0042, B:30:0x004e, B:31:0x0053, B:33:0x0054, B:34:0x0056, B:35:0x0057, B:36:0x0059, B:37:0x005a, B:38:0x005c), top: B:3:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x000e, B:6:0x0013, B:8:0x0017, B:10:0x001b, B:12:0x0025, B:18:0x0030, B:21:0x0034, B:26:0x004c, B:29:0x0042, B:30:0x004e, B:31:0x0053, B:33:0x0054, B:34:0x0056, B:35:0x0057, B:36:0x0059, B:37:0x005a, B:38:0x005c), top: B:3:0x000e }] */
    @Override // s1.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int s() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f8675m
            s1.l r0 = (s1.l) r0
            r0.i()
            java.lang.Object r0 = r9.f8674l
            s1.f r0 = (s1.f) r0
            java.lang.Object r1 = r0.f8689a
            monitor-enter(r1)
            java.lang.IllegalStateException r2 = r0.f8701n     // Catch: java.lang.Throwable -> L32
            r3 = 0
            if (r2 != 0) goto L5a
            android.media.MediaCodec$CodecException r2 = r0.f8697j     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L57
            android.media.MediaCodec$CryptoException r2 = r0.f8698k     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L54
            long r2 = r0.f8699l     // Catch: java.lang.Throwable -> L32
            r4 = 0
            r6 = 0
            r7 = 1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 > 0) goto L2c
            boolean r2 = r0.f8700m     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L2a
            goto L2c
        L2a:
            r2 = 0
            goto L2d
        L2c:
            r2 = 1
        L2d:
            r3 = -1
            if (r2 == 0) goto L34
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            return r3
        L32:
            r0 = move-exception
            goto L5d
        L34:
            o3.r r0 = r0.f8692d     // Catch: java.lang.Throwable -> L32
            int r2 = r0.f7795b     // Catch: java.lang.Throwable -> L32
            int r4 = r0.f7796c     // Catch: java.lang.Throwable -> L32
            if (r2 != r4) goto L3d
            r6 = 1
        L3d:
            if (r6 == 0) goto L40
            goto L4c
        L40:
            if (r2 == r4) goto L4e
            int[] r3 = r0.f7794a     // Catch: java.lang.Throwable -> L32
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L32
            int r2 = r2 + r7
            int r4 = r0.f7797d     // Catch: java.lang.Throwable -> L32
            r2 = r2 & r4
            r0.f7795b = r2     // Catch: java.lang.Throwable -> L32
        L4c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            return r3
        L4e:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException     // Catch: java.lang.Throwable -> L32
            r0.<init>()     // Catch: java.lang.Throwable -> L32
            throw r0     // Catch: java.lang.Throwable -> L32
        L54:
            r0.f8698k = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L57:
            r0.f8697j = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L5a:
            r0.f8701n = r3     // Catch: java.lang.Throwable -> L32
            throw r2     // Catch: java.lang.Throwable -> L32
        L5d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L32
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c.s():int");
    }

    @Override // s1.k
    public void setParameters(Bundle bundle) {
        ((l) this.f8675m).setParameters(bundle);
    }

    public c(MediaCodec mediaCodec, HandlerThread handlerThread, l lVar) {
        this.f8673k = mediaCodec;
        this.f8674l = new f(handlerThread);
        this.f8675m = lVar;
        this.f8671i = 0;
    }
}
