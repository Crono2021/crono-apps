.class public Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadData;
.super Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallbackQueryPayloadData"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x75e1c39a


# instance fields
.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9312
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 9313
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 9303
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 9304
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadData;->data:[B

    .line 9305
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9309
    const v0, -0x75e1c39a

    return v0
.end method
