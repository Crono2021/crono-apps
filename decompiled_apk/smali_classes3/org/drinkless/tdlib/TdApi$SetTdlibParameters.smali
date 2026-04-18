.class public Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetTdlibParameters"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e3f09d2


# instance fields
.field public apiHash:Ljava/lang/String;

.field public apiId:I

.field public applicationVersion:Ljava/lang/String;

.field public databaseDirectory:Ljava/lang/String;

.field public databaseEncryptionKey:[B

.field public deviceModel:Ljava/lang/String;

.field public filesDirectory:Ljava/lang/String;

.field public systemLanguageCode:Ljava/lang/String;

.field public systemVersion:Ljava/lang/String;

.field public useChatInfoDatabase:Z

.field public useFileDatabase:Z

.field public useMessageDatabase:Z

.field public useSecretChats:Z

.field public useTestDc:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54426
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 54427
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;[BZZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "bArr"    # [B
    .param p5, "z9"    # Z
    .param p6, "z10"    # Z
    .param p7, "z11"    # Z
    .param p8, "z12"    # Z
    .param p9, "i9"    # I
    .param p10, "str3"    # Ljava/lang/String;
    .param p11, "str4"    # Ljava/lang/String;
    .param p12, "str5"    # Ljava/lang/String;
    .param p13, "str6"    # Ljava/lang/String;
    .param p14, "str7"    # Ljava/lang/String;

    .line 54404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 54405
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->useTestDc:Z

    .line 54406
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->databaseDirectory:Ljava/lang/String;

    .line 54407
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->filesDirectory:Ljava/lang/String;

    .line 54408
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->databaseEncryptionKey:[B

    .line 54409
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->useFileDatabase:Z

    .line 54410
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->useChatInfoDatabase:Z

    .line 54411
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->useMessageDatabase:Z

    .line 54412
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->useSecretChats:Z

    .line 54413
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->apiId:I

    .line 54414
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->apiHash:Ljava/lang/String;

    .line 54415
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->systemLanguageCode:Ljava/lang/String;

    .line 54416
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->deviceModel:Ljava/lang/String;

    .line 54417
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->systemVersion:Ljava/lang/String;

    .line 54418
    iput-object p14, p0, Lorg/drinkless/tdlib/TdApi$SetTdlibParameters;->applicationVersion:Ljava/lang/String;

    .line 54419
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54423
    const v0, -0x2e3f09d2

    return v0
.end method
