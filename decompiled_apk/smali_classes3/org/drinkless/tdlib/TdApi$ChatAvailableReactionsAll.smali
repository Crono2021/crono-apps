.class public Lorg/drinkless/tdlib/TdApi$ChatAvailableReactionsAll;
.super Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatAvailableReactionsAll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29600b97


# instance fields
.field public maxReactionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9726
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;-><init>()V

    .line 9727
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9717
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;-><init>()V

    .line 9718
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactionsAll;->maxReactionCount:I

    .line 9719
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9723
    const v0, 0x29600b97

    return v0
.end method
