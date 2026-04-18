.class public Lorg/drinkless/tdlib/TdApi$Session;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Session"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9759a3c


# instance fields
.field public apiId:I

.field public applicationName:Ljava/lang/String;

.field public applicationVersion:Ljava/lang/String;

.field public canAcceptCalls:Z

.field public canAcceptSecretChats:Z

.field public deviceModel:Ljava/lang/String;

.field public id:J

.field public ipAddress:Ljava/lang/String;

.field public isCurrent:Z

.field public isOfficialApplication:Z

.field public isPasswordPending:Z

.field public isUnconfirmed:Z

.field public lastActiveDate:I

.field public location:Ljava/lang/String;

.field public logInDate:I

.field public platform:Ljava/lang/String;

.field public systemVersion:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$SessionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55405
    return-void
.end method

.method public constructor <init>(JZZZZZLorg/drinkless/tdlib/TdApi$SessionType;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z
    .param p6, "z11"    # Z
    .param p7, "z12"    # Z
    .param p8, "sessionType"    # Lorg/drinkless/tdlib/TdApi$SessionType;
    .param p9, "i9"    # I
    .param p10, "str"    # Ljava/lang/String;
    .param p11, "str2"    # Ljava/lang/String;
    .param p12, "z13"    # Z
    .param p13, "str3"    # Ljava/lang/String;
    .param p14, "str4"    # Ljava/lang/String;
    .param p15, "str5"    # Ljava/lang/String;
    .param p16, "i10"    # I
    .param p17, "i11"    # I
    .param p18, "str6"    # Ljava/lang/String;
    .param p19, "str7"    # Ljava/lang/String;

    .line 55378
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55379
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Session;->id:J

    .line 55380
    move/from16 v3, p3

    iput-boolean v3, v0, Lorg/drinkless/tdlib/TdApi$Session;->isCurrent:Z

    .line 55381
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$Session;->isPasswordPending:Z

    .line 55382
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$Session;->isUnconfirmed:Z

    .line 55383
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$Session;->canAcceptSecretChats:Z

    .line 55384
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$Session;->canAcceptCalls:Z

    .line 55385
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$Session;->type:Lorg/drinkless/tdlib/TdApi$SessionType;

    .line 55386
    move/from16 v9, p9

    iput v9, v0, Lorg/drinkless/tdlib/TdApi$Session;->apiId:I

    .line 55387
    move-object/from16 v10, p10

    iput-object v10, v0, Lorg/drinkless/tdlib/TdApi$Session;->applicationName:Ljava/lang/String;

    .line 55388
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$Session;->applicationVersion:Ljava/lang/String;

    .line 55389
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Session;->isOfficialApplication:Z

    .line 55390
    move-object/from16 v13, p13

    iput-object v13, v0, Lorg/drinkless/tdlib/TdApi$Session;->deviceModel:Ljava/lang/String;

    .line 55391
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$Session;->platform:Ljava/lang/String;

    .line 55392
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$Session;->systemVersion:Ljava/lang/String;

    .line 55393
    move/from16 v1, p16

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Session;->logInDate:I

    .line 55394
    move/from16 v2, p17

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$Session;->lastActiveDate:I

    .line 55395
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Session;->ipAddress:Ljava/lang/String;

    .line 55396
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Session;->location:Ljava/lang/String;

    .line 55397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55401
    const v0, 0x9759a3c

    return v0
.end method
