.class public Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApprovalFailed;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSuggestedPostApprovalFailed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x687822ed


# instance fields
.field public price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

.field public suggestedPostMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28665
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SuggestedPostPrice;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "suggestedPostPrice"    # Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

    .line 28654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28655
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApprovalFailed;->suggestedPostMessageId:J

    .line 28656
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApprovalFailed;->price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

    .line 28657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28661
    const v0, 0x687822ed

    return v0
.end method
