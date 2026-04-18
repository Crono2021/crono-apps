.class public Lorg/drinkless/tdlib/TdApi$CallServerTypeWebrtc;
.super Lorg/drinkless/tdlib/TdApi$CallServerType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallServerTypeWebrtc"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a8afd65


# instance fields
.field public password:Ljava/lang/String;

.field public supportsStun:Z

.field public supportsTurn:Z

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallServerType;-><init>()V

    .line 42631
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 42618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallServerType;-><init>()V

    .line 42619
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeWebrtc;->username:Ljava/lang/String;

    .line 42620
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeWebrtc;->password:Ljava/lang/String;

    .line 42621
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeWebrtc;->supportsTurn:Z

    .line 42622
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$CallServerTypeWebrtc;->supportsStun:Z

    .line 42623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42627
    const v0, 0x4a8afd65    # 4554418.5f

    return v0
.end method
