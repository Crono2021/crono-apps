.class public Lorg/drinkless/tdlib/TdApi$BotVerification;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotVerification"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e9f490e


# instance fields
.field public botUserId:J

.field public customDescription:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public iconCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35839
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 35827
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35828
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BotVerification;->botUserId:J

    .line 35829
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$BotVerification;->iconCustomEmojiId:J

    .line 35830
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$BotVerification;->customDescription:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 35831
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35835
    const v0, -0x4e9f490e

    return v0
.end method
