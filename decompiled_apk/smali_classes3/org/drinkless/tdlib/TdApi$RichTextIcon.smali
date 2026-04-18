.class public Lorg/drinkless/tdlib/TdApi$RichTextIcon;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextIcon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x583bd4fe


# instance fields
.field public document:Lorg/drinkless/tdlib/TdApi$Document;

.field public height:I

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39669
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Document;II)V
    .locals 0
    .param p1, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 39657
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 39658
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextIcon;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 39659
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$RichTextIcon;->width:I

    .line 39660
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$RichTextIcon;->height:I

    .line 39661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39665
    const v0, -0x583bd4fe

    return v0
.end method
