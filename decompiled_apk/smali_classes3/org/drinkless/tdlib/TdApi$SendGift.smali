.class public Lorg/drinkless/tdlib/TdApi$SendGift;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendGift"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x477cb8d6


# instance fields
.field public giftId:J

.field public isPrivate:Z

.field public ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public payForUpgrade:Z

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48606
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48607
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$FormattedText;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z

    .line 48593
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48594
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendGift;->giftId:J

    .line 48595
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendGift;->ownerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48596
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendGift;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 48597
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SendGift;->isPrivate:Z

    .line 48598
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SendGift;->payForUpgrade:Z

    .line 48599
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48603
    const v0, -0x477cb8d6

    return v0
.end method
