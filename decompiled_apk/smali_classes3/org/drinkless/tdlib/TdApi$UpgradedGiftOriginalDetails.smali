.class public Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradedGiftOriginalDetails"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34b0370


# instance fields
.field public date:I

.field public receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46350
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46351
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$FormattedText;I)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "messageSender2"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "i9"    # I

    .line 46338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46339
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 46340
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;->receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 46341
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 46342
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$UpgradedGiftOriginalDetails;->date:I

    .line 46343
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46347
    const v0, 0x34b0370

    return v0
.end method
