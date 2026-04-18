.class public Lorg/drinkless/tdlib/TdApi$PageBlockListItem;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockListItem"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x13436e53


# instance fields
.field public label:Ljava/lang/String;

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29065
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$PageBlock;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 29054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29055
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockListItem;->label:Ljava/lang/String;

    .line 29056
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockListItem;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 29057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29061
    const v0, 0x13436e53

    return v0
.end method
