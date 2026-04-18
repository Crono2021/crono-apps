.class public Lorg/drinkless/tdlib/TdApi$PageBlockTable;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockTable"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x382fafc8


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$RichText;

.field public cells:[[Lorg/drinkless/tdlib/TdApi$PageBlockTableCell;

.field public isBordered:Z

.field public isStriped:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44479
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;[[Lorg/drinkless/tdlib/TdApi$PageBlockTableCell;ZZ)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "pageBlockTableCellArr"    # [[Lorg/drinkless/tdlib/TdApi$PageBlockTableCell;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 44466
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 44467
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockTable;->caption:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 44468
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockTable;->cells:[[Lorg/drinkless/tdlib/TdApi$PageBlockTableCell;

    .line 44469
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PageBlockTable;->isBordered:Z

    .line 44470
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PageBlockTable;->isStriped:Z

    .line 44471
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44475
    const v0, -0x382fafc8

    return v0
.end method
