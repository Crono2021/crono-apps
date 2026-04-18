.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallback;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeCallback"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x43348403


# instance fields
.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14280
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14281
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14271
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14272
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallback;->data:[B

    .line 14273
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14277
    const v0, -0x43348403

    return v0
.end method
