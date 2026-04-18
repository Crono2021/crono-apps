.class public Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadDataWithPassword;
.super Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallbackQueryPayloadDataWithPassword"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4fe2d8f2


# instance fields
.field public data:[B

.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 23485
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[B)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "bArr"    # [B

    .line 23474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 23475
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadDataWithPassword;->password:Ljava/lang/String;

    .line 23476
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadDataWithPassword;->data:[B

    .line 23477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23481
    const v0, 0x4fe2d8f2

    return v0
.end method
