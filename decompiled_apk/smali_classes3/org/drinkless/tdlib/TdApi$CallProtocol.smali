.class public Lorg/drinkless/tdlib/TdApi$CallProtocol;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallProtocol"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x401bc991


# instance fields
.field public libraryVersions:[Ljava/lang/String;

.field public maxLayer:I

.field public minLayer:I

.field public udpP2p:Z

.field public udpReflector:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46682
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46683
    return-void
.end method

.method public constructor <init>(ZZII[Ljava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "strArr"    # [Ljava/lang/String;

    .line 46669
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46670
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$CallProtocol;->udpP2p:Z

    .line 46671
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CallProtocol;->udpReflector:Z

    .line 46672
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$CallProtocol;->minLayer:I

    .line 46673
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$CallProtocol;->maxLayer:I

    .line 46674
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CallProtocol;->libraryVersions:[Ljava/lang/String;

    .line 46675
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46679
    const v0, -0x401bc991

    return v0
.end method
