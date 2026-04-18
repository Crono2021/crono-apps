.class public Lorg/drinkless/tdlib/TdApi$MessageChatBoost;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5e5f658b


# instance fields
.field public boostCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16260
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16261
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16251
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16252
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatBoost;->boostCount:I

    .line 16253
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16257
    const v0, 0x5e5f658b

    return v0
.end method
