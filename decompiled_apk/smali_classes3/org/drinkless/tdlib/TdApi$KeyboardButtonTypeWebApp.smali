.class public Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeWebApp;
.super Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KeyboardButtonTypeWebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x70c8ff62


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 15685
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15675
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 15676
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeWebApp;->url:Ljava/lang/String;

    .line 15677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15681
    const v0, 0x70c8ff62

    return v0
.end method
