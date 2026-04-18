.class public Lorg/drinkless/tdlib/TdApi$MessageSenders;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSenders"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2922fb83


# instance fields
.field public senders:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28605
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 28594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28595
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSenders;->totalCount:I

    .line 28596
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageSenders;->senders:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 28597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28601
    const v0, -0x2922fb83

    return v0
.end method
