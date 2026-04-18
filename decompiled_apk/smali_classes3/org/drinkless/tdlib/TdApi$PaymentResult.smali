.class public Lorg/drinkless/tdlib/TdApi$PaymentResult;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentResult"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ff017a3


# instance fields
.field public success:Z

.field public verificationUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29285
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;

    .line 29274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29275
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentResult;->success:Z

    .line 29276
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentResult;->verificationUrl:Ljava/lang/String;

    .line 29277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29281
    const v0, -0x2ff017a3

    return v0
.end method
