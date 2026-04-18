.class public Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApproved;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSuggestedPostApproved"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x21953051


# instance fields
.field public price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

.field public sendDate:I

.field public suggestedPostMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38656
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38657
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SuggestedPostPrice;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "suggestedPostPrice"    # Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;
    .param p4, "i9"    # I

    .line 38645
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38646
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApproved;->suggestedPostMessageId:J

    .line 38647
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApproved;->price:Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;

    .line 38648
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostApproved;->sendDate:I

    .line 38649
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38653
    const v0, 0x21953051

    return v0
.end method
