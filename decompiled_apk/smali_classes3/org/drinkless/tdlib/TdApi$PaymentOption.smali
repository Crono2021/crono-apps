.class public Lorg/drinkless/tdlib/TdApi$PaymentOption;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x11866765


# instance fields
.field public title:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29225
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 29214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29215
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentOption;->title:Ljava/lang/String;

    .line 29216
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PaymentOption;->url:Ljava/lang/String;

    .line 29217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29221
    const v0, -0x11866765

    return v0
.end method
