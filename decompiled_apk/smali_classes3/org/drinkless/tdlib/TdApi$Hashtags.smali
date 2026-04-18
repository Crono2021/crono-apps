.class public Lorg/drinkless/tdlib/TdApi$Hashtags;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Hashtags"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x285721a5


# instance fields
.field public hashtags:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14209
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 14199
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 14200
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Hashtags;->hashtags:[Ljava/lang/String;

    .line 14201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14205
    const v0, 0x285721a5

    return v0
.end method
