.class public Lorg/drinkless/tdlib/TdApi$RichTextAnchor;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextAnchor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e7f1034


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18943
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18933
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 18934
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextAnchor;->name:Ljava/lang/String;

    .line 18935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18939
    const v0, 0x4e7f1034

    return v0
.end method
