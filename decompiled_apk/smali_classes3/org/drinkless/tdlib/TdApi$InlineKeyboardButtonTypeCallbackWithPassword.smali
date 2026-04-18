.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallbackWithPassword;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeCallbackWithPassword"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x361f4248


# instance fields
.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14299
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 14289
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14290
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeCallbackWithPassword;->data:[B

    .line 14291
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14295
    const v0, 0x361f4248

    return v0
.end method
