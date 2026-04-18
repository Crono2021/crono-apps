.class public Lorg/drinkless/tdlib/TdApi$SavedCredentials;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SavedCredentials"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1611eb24


# instance fields
.field public id:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30489
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 30478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 30479
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SavedCredentials;->id:Ljava/lang/String;

    .line 30480
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SavedCredentials;->title:Ljava/lang/String;

    .line 30481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30485
    const v0, -0x1611eb24

    return v0
.end method
