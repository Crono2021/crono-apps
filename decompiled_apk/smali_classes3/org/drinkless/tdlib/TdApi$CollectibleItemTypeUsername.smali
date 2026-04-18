.class public Lorg/drinkless/tdlib/TdApi$CollectibleItemTypeUsername;
.super Lorg/drinkless/tdlib/TdApi$CollectibleItemType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CollectibleItemTypeUsername"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1b56e7d1


# instance fields
.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10950
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CollectibleItemType;-><init>()V

    .line 10951
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10941
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CollectibleItemType;-><init>()V

    .line 10942
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CollectibleItemTypeUsername;->username:Ljava/lang/String;

    .line 10943
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10947
    const v0, 0x1b56e7d1

    return v0
.end method
