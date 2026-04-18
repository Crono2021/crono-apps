.class public Lorg/drinkless/tdlib/TdApi$GetCollectibleItemInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCollectibleItemInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CollectibleItemInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xcfb5276


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$CollectibleItemType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12642
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12643
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$CollectibleItemType;)V
    .locals 0
    .param p1, "collectibleItemType"    # Lorg/drinkless/tdlib/TdApi$CollectibleItemType;

    .line 12633
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12634
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetCollectibleItemInfo;->type:Lorg/drinkless/tdlib/TdApi$CollectibleItemType;

    .line 12635
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12639
    const v0, -0xcfb5276

    return v0
.end method
