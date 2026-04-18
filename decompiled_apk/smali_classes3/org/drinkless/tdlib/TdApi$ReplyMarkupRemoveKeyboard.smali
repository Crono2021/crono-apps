.class public Lorg/drinkless/tdlib/TdApi$ReplyMarkupRemoveKeyboard;
.super Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReplyMarkupRemoveKeyboard"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2933ae8f


# instance fields
.field public isPersonal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 18745
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18735
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 18736
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupRemoveKeyboard;->isPersonal:Z

    .line 18737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18741
    const v0, -0x2933ae8f

    return v0
.end method
