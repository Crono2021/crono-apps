.class public Lorg/drinkless/tdlib/TdApi$RichTextPlain;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextPlain"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1cc42966


# instance fields
.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19032
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19033
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19023
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 19024
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextPlain;->text:Ljava/lang/String;

    .line 19025
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19029
    const v0, 0x1cc42966

    return v0
.end method
