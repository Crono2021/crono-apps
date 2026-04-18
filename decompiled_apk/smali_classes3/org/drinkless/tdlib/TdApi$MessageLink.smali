.class public Lorg/drinkless/tdlib/TdApi$MessageLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x50b5c55a


# instance fields
.field public isPublic:Z

.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28485
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 28474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28475
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageLink;->link:Ljava/lang/String;

    .line 28476
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageLink;->isPublic:Z

    .line 28477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28481
    const v0, -0x50b5c55a

    return v0
.end method
