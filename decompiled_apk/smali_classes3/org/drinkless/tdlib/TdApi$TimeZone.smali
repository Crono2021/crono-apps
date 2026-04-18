.class public Lorg/drinkless/tdlib/TdApi$TimeZone;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TimeZone"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x46e60d23


# instance fields
.field public id:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public utcTimeOffset:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41032
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41033
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 41021
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41022
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TimeZone;->id:Ljava/lang/String;

    .line 41023
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TimeZone;->name:Ljava/lang/String;

    .line 41024
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$TimeZone;->utcTimeOffset:I

    .line 41025
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41029
    const v0, -0x46e60d23

    return v0
.end method
