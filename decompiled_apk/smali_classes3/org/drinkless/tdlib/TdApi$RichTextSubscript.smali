.class public Lorg/drinkless/tdlib/TdApi$RichTextSubscript;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextSubscript"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x33bfa5b4


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19069
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19059
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19060
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextSubscript;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 19061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19065
    const v0, -0x33bfa5b4    # -5.042411E7f

    return v0
.end method
