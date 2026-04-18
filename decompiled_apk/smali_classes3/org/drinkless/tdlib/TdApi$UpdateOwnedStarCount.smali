.class public Lorg/drinkless/tdlib/TdApi$UpdateOwnedStarCount;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateOwnedStarCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x50814078


# instance fields
.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21909
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarAmount;)V
    .locals 0
    .param p1, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 21899
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21900
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateOwnedStarCount;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 21901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21905
    const v0, -0x50814078

    return v0
.end method
