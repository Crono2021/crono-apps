.class public Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostPaid;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSuggestedPostPaid"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5de74ba9


# instance fields
.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public suggestedPostMessageId:J

.field public tonAmount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38679
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$StarAmount;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p4, "j9"    # J

    .line 38667
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38668
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostPaid;->suggestedPostMessageId:J

    .line 38669
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostPaid;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 38670
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostPaid;->tonAmount:J

    .line 38671
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38675
    const v0, 0x5de74ba9

    return v0
.end method
