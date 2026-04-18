.class public Lorg/drinkless/tdlib/TdApi$SearchStickerSet;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchStickerSet"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StickerSet;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63eec702


# instance fields
.field public ignoreCache:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30689
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 30678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30679
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchStickerSet;->name:Ljava/lang/String;

    .line 30680
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$SearchStickerSet;->ignoreCache:Z

    .line 30681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30685
    const v0, 0x63eec702

    return v0
.end method
