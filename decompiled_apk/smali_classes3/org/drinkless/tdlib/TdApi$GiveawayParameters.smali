.class public Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x45d46caa


# instance fields
.field public additionalChatIds:[J

.field public boostedChatId:J

.field public countryCodes:[Ljava/lang/String;

.field public hasPublicWinners:Z

.field public onlyNewMembers:Z

.field public prizeDescription:Ljava/lang/String;

.field public winnersSelectionDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51375
    return-void
.end method

.method public constructor <init>(J[JIZZ[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J
    .param p4, "i9"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "strArr"    # [Ljava/lang/String;
    .param p8, "str"    # Ljava/lang/String;

    .line 51359
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51360
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->boostedChatId:J

    .line 51361
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->additionalChatIds:[J

    .line 51362
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->winnersSelectionDate:I

    .line 51363
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->onlyNewMembers:Z

    .line 51364
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->hasPublicWinners:Z

    .line 51365
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->countryCodes:[Ljava/lang/String;

    .line 51366
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$GiveawayParameters;->prizeDescription:Ljava/lang/String;

    .line 51367
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51371
    const v0, 0x45d46caa

    return v0
.end method
