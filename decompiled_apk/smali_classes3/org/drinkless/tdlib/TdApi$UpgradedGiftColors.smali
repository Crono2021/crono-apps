.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftColors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2c51f156


# instance fields
.field public darkThemeAccentColor:I

.field public darkThemeColors:[I

.field public id:J

.field public lightThemeAccentColor:I

.field public lightThemeColors:[I

.field public modelCustomEmojiId:J

.field public symbolCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51855
    return-void
.end method

.method public constructor <init>(JJJI[II[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "i9"    # I
    .param p8, "iArr"    # [I
    .param p9, "i10"    # I
    .param p10, "iArr2"    # [I

    .line 51839
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51840
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->id:J

    .line 51841
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->modelCustomEmojiId:J

    .line 51842
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->symbolCustomEmojiId:J

    .line 51843
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->lightThemeAccentColor:I

    .line 51844
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->lightThemeColors:[I

    .line 51845
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->darkThemeAccentColor:I

    .line 51846
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;->darkThemeColors:[I

    .line 51847
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51851
    const v0, 0x2c51f156

    return v0
.end method
