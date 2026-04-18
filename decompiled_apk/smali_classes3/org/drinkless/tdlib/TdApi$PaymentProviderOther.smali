.class public Lorg/drinkless/tdlib/TdApi$PaymentProviderOther;
.super Lorg/drinkless/tdlib/TdApi$PaymentProvider;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentProviderOther"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4faf1f1c


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17736
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 17737
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17727
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentProvider;-><init>()V

    .line 17728
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentProviderOther;->url:Ljava/lang/String;

    .line 17729
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17733
    const v0, -0x4faf1f1c

    return v0
.end method
