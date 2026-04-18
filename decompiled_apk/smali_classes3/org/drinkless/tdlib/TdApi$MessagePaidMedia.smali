.class public Lorg/drinkless/tdlib/TdApi$MessagePaidMedia;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePaidMedia"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2b32cef9


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

.field public showCaptionAboveMedia:Z

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44286
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 44287
    return-void
.end method

.method public constructor <init>(J[Lorg/drinkless/tdlib/TdApi$PaidMedia;Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "paidMediaArr"    # [Lorg/drinkless/tdlib/TdApi$PaidMedia;
    .param p4, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p5, "z8"    # Z

    .line 44274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 44275
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMedia;->starCount:J

    .line 44276
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMedia;->media:[Lorg/drinkless/tdlib/TdApi$PaidMedia;

    .line 44277
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMedia;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 44278
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$MessagePaidMedia;->showCaptionAboveMedia:Z

    .line 44279
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44283
    const v0, -0x2b32cef9

    return v0
.end method
