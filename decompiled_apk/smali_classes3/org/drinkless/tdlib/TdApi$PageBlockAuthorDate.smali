.class public Lorg/drinkless/tdlib/TdApi$PageBlockAuthorDate;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockAuthorDate"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d7ff410


# instance fields
.field public author:Lorg/drinkless/tdlib/TdApi$RichText;

.field public publishDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 28985
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;I)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "i9"    # I

    .line 28974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 28975
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAuthorDate;->author:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 28976
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockAuthorDate;->publishDate:I

    .line 28977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28981
    const v0, 0x4d7ff410    # 2.6838656E8f

    return v0
.end method
