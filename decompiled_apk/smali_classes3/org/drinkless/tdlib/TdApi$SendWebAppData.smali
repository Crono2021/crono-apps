.class public Lorg/drinkless/tdlib/TdApi$SendWebAppData;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendWebAppData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x54e031f4


# instance fields
.field public botUserId:J

.field public buttonText:Ljava/lang/String;

.field public data:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40042
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40043
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 40031
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40032
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppData;->botUserId:J

    .line 40033
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppData;->buttonText:Ljava/lang/String;

    .line 40034
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppData;->data:Ljava/lang/String;

    .line 40035
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40039
    const v0, -0x54e031f4

    return v0
.end method
