.class public Lorg/drinkless/tdlib/TdApi$PageBlockDetails;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockDetails"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5f5c1371


# instance fields
.field public header:Lorg/drinkless/tdlib/TdApi$RichText;

.field public isOpen:Z

.field public pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38810
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38811
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;[Lorg/drinkless/tdlib/TdApi$PageBlock;Z)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "pageBlockArr"    # [Lorg/drinkless/tdlib/TdApi$PageBlock;
    .param p3, "z8"    # Z

    .line 38799
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 38800
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockDetails;->header:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 38801
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockDetails;->pageBlocks:[Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 38802
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockDetails;->isOpen:Z

    .line 38803
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38807
    const v0, -0x5f5c1371

    return v0
.end method
