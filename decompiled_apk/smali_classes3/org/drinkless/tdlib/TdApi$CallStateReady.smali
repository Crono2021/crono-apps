.class public Lorg/drinkless/tdlib/TdApi$CallStateReady;
.super Lorg/drinkless/tdlib/TdApi$CallState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallStateReady"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10cb9319


# instance fields
.field public allowP2p:Z

.field public config:Ljava/lang/String;

.field public customParameters:Ljava/lang/String;

.field public emojis:[Ljava/lang/String;

.field public encryptionKey:[B

.field public isGroupCallSupported:Z

.field public protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;

.field public servers:[Lorg/drinkless/tdlib/TdApi$CallServer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51980
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 51981
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$CallProtocol;[Lorg/drinkless/tdlib/TdApi$CallServer;Ljava/lang/String;[B[Ljava/lang/String;ZZLjava/lang/String;)V
    .locals 0
    .param p1, "callProtocol"    # Lorg/drinkless/tdlib/TdApi$CallProtocol;
    .param p2, "callServerArr"    # [Lorg/drinkless/tdlib/TdApi$CallServer;
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "bArr"    # [B
    .param p5, "strArr"    # [Ljava/lang/String;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "str2"    # Ljava/lang/String;

    .line 51964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallState;-><init>()V

    .line 51965
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->protocol:Lorg/drinkless/tdlib/TdApi$CallProtocol;

    .line 51966
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->servers:[Lorg/drinkless/tdlib/TdApi$CallServer;

    .line 51967
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->config:Ljava/lang/String;

    .line 51968
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->encryptionKey:[B

    .line 51969
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->emojis:[Ljava/lang/String;

    .line 51970
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->allowP2p:Z

    .line 51971
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->isGroupCallSupported:Z

    .line 51972
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$CallStateReady;->customParameters:Ljava/lang/String;

    .line 51973
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51977
    const v0, -0x10cb9319

    return v0
.end method
