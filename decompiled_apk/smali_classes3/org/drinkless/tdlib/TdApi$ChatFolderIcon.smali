.class public Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderIcon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x8b55f1a


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10159
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10149
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10150
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;->name:Ljava/lang/String;

    .line 10151
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10155
    const v0, -0x8b55f1a

    return v0
.end method
