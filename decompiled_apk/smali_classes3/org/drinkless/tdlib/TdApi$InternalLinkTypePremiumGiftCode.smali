.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumGiftCode;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePremiumGiftCode"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x21a3676e


# instance fields
.field public code:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15450
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15451
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15441
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15442
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePremiumGiftCode;->code:Ljava/lang/String;

    .line 15443
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15447
    const v0, -0x21a3676e

    return v0
.end method
