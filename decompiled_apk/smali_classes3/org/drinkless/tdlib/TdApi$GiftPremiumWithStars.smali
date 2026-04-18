.class public Lorg/drinkless/tdlib/TdApi$GiftPremiumWithStars;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftPremiumWithStars"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ab09f28


# instance fields
.field public monthCount:I

.field public starCount:J

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43686
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43687
    return-void
.end method

.method public constructor <init>(JJILorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43675
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiftPremiumWithStars;->userId:J

    .line 43676
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GiftPremiumWithStars;->starCount:J

    .line 43677
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GiftPremiumWithStars;->monthCount:I

    .line 43678
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GiftPremiumWithStars;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43679
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43683
    const v0, -0x7ab09f28

    return v0
.end method
