.class public Lorg/drinkless/tdlib/TdApi$FormattedText;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FormattedText"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xf0ebeb4


# instance fields
.field public entities:[Lorg/drinkless/tdlib/TdApi$TextEntity;

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25565
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$TextEntity;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "textEntityArr"    # [Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 25554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25555
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FormattedText;->text:Ljava/lang/String;

    .line 25556
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FormattedText;->entities:[Lorg/drinkless/tdlib/TdApi$TextEntity;

    .line 25557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25561
    const v0, -0xf0ebeb4

    return v0
.end method
