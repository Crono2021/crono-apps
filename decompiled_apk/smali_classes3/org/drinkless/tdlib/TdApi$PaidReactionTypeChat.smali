.class public Lorg/drinkless/tdlib/TdApi$PaidReactionTypeChat;
.super Lorg/drinkless/tdlib/TdApi$PaidReactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaidReactionTypeChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x28479d9c


# instance fields
.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17340
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidReactionType;-><init>()V

    .line 17341
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 17331
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaidReactionType;-><init>()V

    .line 17332
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PaidReactionTypeChat;->chatId:J

    .line 17333
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17337
    const v0, -0x28479d9c

    return v0
.end method
