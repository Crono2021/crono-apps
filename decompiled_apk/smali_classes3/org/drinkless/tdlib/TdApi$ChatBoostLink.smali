.class public Lorg/drinkless/tdlib/TdApi$ChatBoostLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4abe838f


# instance fields
.field public isPublic:Z

.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23605
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 23594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23595
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLink;->link:Ljava/lang/String;

    .line 23596
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLink;->isPublic:Z

    .line 23597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23601
    const v0, -0x4abe838f

    return v0
.end method
